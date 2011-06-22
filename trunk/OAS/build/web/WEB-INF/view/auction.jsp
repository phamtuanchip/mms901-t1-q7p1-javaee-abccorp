<%@page import="entity.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : auction
    Created on : May 15, 2011, 12:12:16 AM
    Author     : Hoang Manh Hung
--%>
vbvbvb
<%
System.out.print("error");
%>
        <sql:query var="categories" dataSource="jdbc/OAS">
            SELECT * FROM APP."Category"
        </sql:query>
        <sql:query var="selectedCategory" dataSource="jdbc/OAS">
            SELECT "CategoryName" FROM APP."Category" WHERE "CategoryId" = ?
            <sql:param value='${pageContext.request.attribute("id")}'/>
        </sql:query>
        <sql:query var="categoryProducts" dataSource="jdbc/OAS">
            SELECT * FROM APP."Product" p JOIN APP."AuctionInfo" ai
            ON p."ProductId" = ai."ProductId"
            WHERE "CategoryId" = ?
            <sql:param value="${pageContext.request.queryString}"/>
        </sql:query>
            
        <div id="categoryLeftColumn">
            <c:forEach var="category" items="${categories.rows}">
                <c:choose>
                    <c:when test="${category.CategoryId == pageContext.request.queryString}">
                        <div class="categoryButton" id="selectedCategory">
                            <span class="categoryText">
                                ${category.CategoryName}
                            </span>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <a href="auction?${category.CategoryId}" class="categoryButton">
                            <div class="categoryText">
                                ${category.CategoryName}
                            </div>
                        </a>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </div>

        <div id="categoryRightColumn">
            <p id="categoryTitle">
                <span style="background-color: #f5eabe; padding: 7px; position: relative;"> ${selectedCategory.rows[0].CategoryName}</span>
            </p>

            <table id="productTable">
                <c:forEach var="product" items="${categoryProducts.rows}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${product.ProductName}.jpg"
                                alt="${product.ProductName}">
                        </td>
                        <td>
                            ${product.ProductName}
                            <br>
                            <span class="smallText">${product.description}</span>
                        </td>
                        <td>
                            &euro; ${product.highestBid} / unit
                        </td>
                        <td>
                            <form action="bid" method="post">
                                <input type="hidden"
                                       name="productId"
                                       value="${product.ProductId}"/>
                                <input type="hidden"
                                       name="highestBid"
                                       value="${product.highestBid}"/>
                                <input type="hidden"
                                       name="catId"
                                       value="${product.highestBid}"/>
                                <input type="submit"
                                       value="Bid"/>
                            </form>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>