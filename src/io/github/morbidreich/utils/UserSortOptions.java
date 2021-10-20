package io.github.morbidreich.utils;

// this class makes sure that correct parameters are passed from
// web request to hibernate query. Default sortBy/order values are only
// changed when Strings in constructor are:
// - present
// - valid
// - other than defaults
public class UserSortOptions implements SortOptions {
	
	private String sortBy = "surname";
	private String order = "asc";
	
	public UserSortOptions(String sortBy, String order) {
		
		if (sortBy != null && sortBy.equals("1"))
			this.sortBy = "name";
		if (order != null && order.equals("2"))
			this.order="desc";
	}

	@Override
	public String getSortBy() {
		return sortBy;
	}

	@Override
	public String getOrder() {
		return order;
	}
}
