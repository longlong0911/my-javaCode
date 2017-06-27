package com.sun.serviceIpl;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.Post;
import com.sun.serviceI.PostServiceI;

@Service
public class PostServiceIpl extends BaseDaoIpl<Post> implements PostServiceI{

}
