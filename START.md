
Project Start Guide
-----------------------------------

![OpenJDK](https://img.shields.io/badge/OpenJDK-1.8-yellow.svg)
![mySQL](https://img.shields.io/badge/mysql-5.7-blue.svg)

![BSD](https://img.shields.io/badge/License-BSD3-blue.svg)


## Start Guide Introduction

Project Name: StackPO Admin Project  
  
This document is intended to provide:    
1.1 Brief Picture of this Project  
1.2 How to Run this Project  
1.3 Project Reference (License & CopyRight)  

## Basic Environment

2.1 Development Environment  

Project Tested as:  
* CentOS 7 
* mySQL 5.7 
* JDK 1.8
* Maven 3.5.3
* Tomcat 8.5

2.2 Stage Environment  
2.3 Production Environment

## Project Building

3.1 get source code from github

``` 
mkdir ~/Projects/hellosoft
cd ~/Project/hellosoft
git clone https://github.com/cranezhou/stack-po-admin-project.git 
```

3.2 setup local database

Please install mysql on your local development computer. 
(refer to official documents)

create a sqldbuser01 by using root account.

``` 
cd ~/Project/hellosoft/stack-po-admin-project/database
mysql -u sqldbuser01 -p
mysql> create database stack_po_admin_db_dev;

mysql> use stack_po_admin_db_dev;
mysql> source stack_po_admin_db_dev.sql
```

3.3 running project on localhost

``` 
cd ~/Project/hellosoft/stack-po-admin-project/
mvn spring-boot:run 
```

3.4 project start demo

``` html
http://localhost:8080/
```

screen figure 3.4.1  
![image]（https://github.com/cranezhou/stack-po-admin-project/blob/master/images/START_scnf030401.png)  
![图片说明1](https://github.com/cranezhou/stack-po-admin-project/blob/master/images/START_scnf030401.png)

## Code Structure

4.1 Main  
screen picture 1 <br>
4.2 Test  
<font color=#0000ff size=3>screen picture 2</font>

## Test Case (Optional) 
5.1 Test Case 1  
5.2 Test Case 2  

## Project Reference
* See [DESIGN](DESIGN) for project design document 
* See [COMPONENTS](COMPONENTS) for project components 
  (official websites reference)

## Contributors
* ISV 1: Crane Zhou
* ISV 2: xxx xxx
* API Vendor 1:
* API Vendor 2:

## License & CopyRight
This Project is released under the terms of the BSD license.  
See [LICENSE](LICENSE) for more information or see:  
https://opensource.org/licenses/BSD-3-Clause.

