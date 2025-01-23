package com.CentralLink.admin.service;

import com.CentralLink.admin.request.BlogRequest;

public interface BlogService {

	long createBlog(BlogRequest blogRequest);

	Object getAllBlogs();

}
