package com.wirtz.ecommerce.model.cartline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
public class Cartline {
	@Column(name = "cartId")
	private long cartlineId;
	
	private UserProfile userProfile;
	
	private Product product;
	private long version;

	public Cartline() {
	}

	public Cartline(final UserProfile userProfile, final Product product) {

		this.userProfile = userProfile;
		this.product = product;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCartlineId() {
		return cartlineId;
	}

	public void setCartlineId(final Long cartlineId) {
		this.cartlineId = cartlineId;
	}
	
	@JoinColumn(name = "usrId")
	@ManyToOne(optional = false)
    public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(final UserProfile userProfile) {
		this.userProfile = userProfile;
	}
    @OneToOne
    @JoinColumn(name="productId")
	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

}
