package com.wirtz.ecommerce.model.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;

@Repository
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {


	
	@SuppressWarnings("unchecked")
	public List<Product> findProductsByKeyword( String keyword, int startIndex, int count) {
		// Flag to indicate if category is set
		

		// Start creating query
		String queryString = "SELECT p FROM Product p " + "WHERE UPPER(p.name) LIKE ";

		if (keyword != null) {
			// Remove leading and trailing white spaces
			keyword.trim();

			// Split input keyword into tokens
			String[] splitKeyword = keyword.split(" ");

			if (splitKeyword.length >= 1) {
				// First token
				queryString += " '%";
				queryString += splitKeyword[0].toUpperCase().trim();
				queryString += "%' ";

				// From second token on
				for (int i = 1; i < splitKeyword.length; i++) {
					if (splitKeyword[i].length() != 0) {
						// Put token into uppercase format in order to do the comparison
						queryString += " AND UPPER(p.name) LIKE '%";
						queryString += splitKeyword[i].toUpperCase().trim();
						queryString += "%' ";
					}
				}
			} else {// Whitespaces keyword
				queryString += " '%' ";
			}
		} else {// No input keyword
			queryString += " '%' ";
		}

		queryString += " ORDER BY p.creationDate ";

			return getSession().createQuery(queryString).setFirstResult(startIndex).setMaxResults(count).list();
	}
}