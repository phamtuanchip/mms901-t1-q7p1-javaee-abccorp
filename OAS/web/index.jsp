<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : May 15, 2011, 12:02:06 AM
    Author     : Hoang Manh Hung
--%>
            <div id="indexLeftColumn">
                <div id="welcomeText">
                    <p style="font-size: larger">Welcome to the online home of the Online Auction System.</p>

                    <p>Enjoy browsing, biding and learning more about our unique home delivery
                        service bringing you plenty of quality products to your doorstep.</p>
                </div>
            </div>

            <div id="indexRightColumn">
                <sql:query var="categories" dataSource="jdbc/OAS">
                    SELECT * FROM APP."Category"
                </sql:query>
                
                <c:forEach var="category" items="${categories.rows}">
                    <div class="categoryBox">
                        <a href="auction?${category.CategoryId}">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.CategoryName}</span>
                            <br/><br/>
                            <img src="${initParam.categoryImagePath}${category.CategoryName}.jpg"
                                 alt="${category.CategoryName}" class="categoryImage" height="300" width="300"></img>
                        </a>
                    </div>
                </c:forEach>
            </div>