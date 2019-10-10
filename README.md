# RemoteAccessProfileManager

**Function:** 

This is a Studnet information management system that can be accessed from any mobile device via browser.

**Project Structure:**

- \< WebContent \>
  - \< lib \>:    Contains the necessary external libraries
  - index.jsp:    The starting page
  - add.jsp:    This page is a form that contains all relevant fields and a SUBMIT button. Upon click, a new student profile will be added to the database.
  - edit.jsp:    This page is a form that shows a specific student's profile. Users can make changes and submit the update to the database.
  - list.jsp:    This page is used to show all the student profiles altogether. There are fields that helps to filter out subsets or individual student(s) of interest. It also provides the buttons to delete / update specific profiles. 
  - list_page.jsp:    This page is used to show student profiles in separate pages (as specified in the Impl class). There are also hyperlinks for the prev /next page, as well as the top / last page, etc. 
- < src \>
  - < servlet \>:    Contains the HttpServlets that is called by the JSP pages
  - < service \>:    Contains the service (interfaces) used to realize servlet functions
  - < service.imp >:    Contains the service implementation class
  - < dao \>:    Contains the DAO (Data Access Object)
  - < impl \>:    Contains the DAO implementation class that does the real job
  - < domain \>:    Contains the data object class file and the bean used to encapsulate data that is displayed on the webpage
  - \< util \>:    Contains some convenient Util classes
  - c3p0-config.xml:    The configuration file that stores information necessary for database connection

**Main Technologies/Concepts:**

- JSP and JSP Expression Language (EL) were used to construct the web page.
- HttpServlet was used to implement web services and realizes all kinds of functions.
- MySQL database was used to store student information.
- JDBC & DBUtils were used to make connection and submit queries to the database.