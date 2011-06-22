<%--
    Document   : checkout
    Created on : May 15, 2011, 12:36:03 AM
    Author     : Hoang Manh Hung
--%>


            <%@page import="entity.Product"%>
<div id="centerColumn">

                <% Product p = (Product)session.getAttribute("test");
                    %>
                <p>name:<%=p.getProductName()%></p>
                <p>id:<%=p.getProductId()%></p>
                
                <h2>checkout</h2>

                <p>[ text ]</p>

                <form action="purchase" method="post">

                    <table id="checkoutTable">
                        <tr>
                            <td>[ form containing fields to
                                <br>capture customer details ]</td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="submit button"></td>
                        </tr>

                    </table>

                </form>

                <div id="infoBox">

                    <div style="border: black solid 1px; height:100px; padding: 10px">
                        [ purchase conditions ]
                    </div>

                    <div id="priceBox">
                        [ purchase calculations:<br>subtotal + delivery charge ]
                    </div>
                </div>
            </div>