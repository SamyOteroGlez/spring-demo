/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tesa
 * Created: 7-Mar-2020
 */

DROP TABLE IF EXISTS posts;
CREATE TABLE posts(id serial PRIMARY KEY, title VARCHAR(255), body TEXT);

