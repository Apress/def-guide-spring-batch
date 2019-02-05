/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.Chapter07.domain;

import org.neo4j.ogm.annotation.Property;

import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @author Michael Minella
 */
@QueryResult
public class Company {

	@Property("s.companyName")
	private String company;
	@Property("c.categoryName")
	private String categoryName;
//	@Property("c.categoryName")
//	private List<String> categories;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	//	public List<String> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(List<String> categories) {
//		this.categories = categories;
//	}

	@Override
	public String toString() {
		return "Company{" +
				"company='" + company + '\'' +
				"categoryName='" + categoryName + '\'' +
//				", categories=" + categories.stream().collect(Collectors.joining(",")) +
				'}';
	}
//
//	public static class Converter implements CompositeAttributeConverter<Company> {
//
//		@Override
//		public Map<String, ?> toGraphProperties(Company company) {
//			Map<String, Object> properties = new HashMap<>();
//
//			if(company != null) {
//				properties.put("companyName", company.getCompany());
//			}
////			Map<String, Double> properties = new HashMap<>();
////			if (location != null)  {
////				properties.put("latitude", location.getLatitude());
////				properties.put("longitude", location.getLongitude());
////			}
//			return properties;
//		}
//
//		@Override
//		public Company toEntityAttribute(Map<String, ?> map) {
//			String companyName = (String) map.get("companyName");
//
//			if(StringUtils.hasText(companyName)) {
//				Company company = new Company();
//				company.setCompany(companyName);
//
//				return company;
//			}
//
////
////
////			Double latitude = (Double) map.get("latitude");
////			Double longitude = (Double) map.get("longitude");
////			if (latitude != null && longitude != null) {
////				return new Company();
////			}
//			return null;
//		}
//
//	}
}
