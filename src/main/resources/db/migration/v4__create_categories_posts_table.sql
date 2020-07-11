/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tesa
 * Created: 11-Mar-2020
 */
DROP TABLE IF EXISTS categories_posts;
CREATE TABLE categories_posts(
    category_id int NOT NULL, 
    post_id int NOT NULL,

    CONSTRAINT categories_id_posts_id_pkey PRIMARY KEY (category_id, post_id),
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
);
