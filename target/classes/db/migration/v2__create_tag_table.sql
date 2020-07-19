/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tesa
 * Created: 11-Mar-2020
 */

DROP TABLE IF EXISTS tags;
CREATE TABLE tags(
    id serial PRIMARY KEY, 
    post_id int, 
    name VARCHAR(255), 
    description TEXT,

    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);
