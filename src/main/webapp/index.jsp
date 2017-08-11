<%--<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
</body>
</html>--%>

<html>
<head>
<title>hrocmms API documentation</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">
        hrocmms API documentation
    </h1>

    <!------------------------------------------------ Inspection --------------------------------------------->
    <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>Inspection</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                POST
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Return inspection details
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/inspection">webapi/inspection</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format</td>
                        <td>Description</td>
                        <%--<td>Example</td>--%>
                    </tr>
                    <tr>
                        <td>fromDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter inspection based on fromDate and toDate</td>
                        <%--<td><a href="webapi/count?fromDate=2017-01-01&toDate=2017-08-31">
                            webapi/inspection?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>--%>
                    </tr>
                    <tr>
                        <td>toDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <%--<td><a href="webapi/count?fromDate=2017-01-01&toDate=2017-08-31">
                            webapi/inspection?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>--%>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Accepts
            </div>
            <div class="col-md-10">
                x-www-form-urlencoded
            </div>
        </div>
        <br>
    </div>
    <!------------------------------------------------ Inspection ends------------------------------------------>

    <!------------------------------------------------ Officer --------------------------------------------->
   <%-- <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>Officer</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                POST
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Return active officers details
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/officer">webapi/officer</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>loginId</td>
                        <td></td>
                        <td>get data of particular officer</td>
                        <td><a href="webapi/officer">
                            webapi/officer
                        </a>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
        <br />
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Accepts
            </div>
            <div class="col-md-10">
                x-www-form-urlencoded
            </div>
        </div>


        <br>
    </div>--%>
    <!------------------------------------------------ Officer ends ------------------------------------------>

    <!------------------------------------------------ Industry --------------------------------------------->
    <%--<div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>Industry</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                POST
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Return industry details
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/industry">webapi/industry</a>
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>loginId</td>
                        <td></td>
                        <td>get data of particular industry</td>
                        <td><a href="webapi/industry">
                            webapi/industry
                        </a>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
        <br />
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Accepts
            </div>
            <div class="col-md-10">
                x-www-form-urlencoded
            </div>
        </div>

    </div>--%>
    <!------------------------------------------------ Industry ends ------------------------------------------>

    <!-- ---------------------------------------------- Count ------------------------------------------------->
    <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>Count</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                GET
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Return the count of no. of applications in CTO, HWM and BMW module
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/count">webapi/count</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link for cto count
            </div>
            <div class="col-md-10">
                <a href="webapi/count/cto">webapi/count/cto</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link for hwm count
            </div>
            <div class="col-md-10">
                <a href="webapi/count/hwm">webapi/count/hwm</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link for bmw count
            </div>
            <div class="col-md-10">
                <a href="webapi/count/hwm">webapi/count/bmw</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>fromDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter cto count based on fromDate and toDate</td>
                        <td><a href="webapi/count/cto?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/count/cto?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>toDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter hwm count based on fromDate and toDate</td>
                        <td><a href="webapi/count/hwm?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/count/hwm?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!-- -------------------------------------------- Counts ends -------------------------------------------->


    <!-- ----------------------------------------------- CTO ------------------------------------------------->
    <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>CTO</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                GET
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Returns CTO Application data
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/cto">webapi/cto</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format/Value</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>fromDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>toDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>ra</td>
                        <td>1</td>
                        <td>return received application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&ra=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&ra=1
                        </a>
                            <br>
                            <a href="webapi/cto?ra=1">
                                webapi/cto?ra=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gwt</td>
                        <td>1</td>
                        <td>return granted within time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&gwt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&gwt=1
                        </a>
                            <br>
                            <a href="webapi/cto?gwt=1">
                                webapi/cto?gwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gbt</td>
                        <td>1</td>
                        <td>return granted beyond time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&gbt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&gbt=1
                        </a>
                            <br>
                            <a href="webapi/cto?gbt=1">
                                webapi/cto?gbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rwt</td>
                        <td>1</td>
                        <td>return rejected within time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&rwt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&rwt=1
                        </a>
                            <br>
                            <a href="webapi/cto?rwt=1">
                                webapi/cto?rwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rbt</td>
                        <td>1</td>
                        <td>return rejected beyond time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&rbt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&rbt=1
                        </a>
                            <br>
                            <a href="webapi/cto?rbt=1">
                                webapi/cto?rbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pwt</td>
                        <td>1</td>
                        <td>return pending within time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&pwt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&pwt=1
                        </a>
                            <br>
                            <a href="webapi/cto?pwt=1">
                                webapi/cto?pwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pbt</td>
                        <td>1</td>
                        <td>return pending beyond time application</td>
                        <td><a href="webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&pbt=1">
                            webapi/cto?fromDate=2017-01-01&toDate=2017-08-01&pbt=1
                        </a>
                            <br>
                            <a href="webapi/cto?pbt=1">
                                webapi/cto?pbt=1
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!-- ---------------------------------------------- CTO ends --------------------------------------------->


    <!-- ----------------------------------------------- HWM ------------------------------------------------->
    <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>HWM</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                GET
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Returns HWM Application data
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/hwm">webapi/hwm</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format/Value</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>fromDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>toDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>ra</td>
                        <td>1</td>
                        <td>return received application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&ra=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&ra=1
                        </a>
                            <br>
                            <a href="webapi/hwm?ra=1">
                                webapi/hwm?ra=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gwt</td>
                        <td>1</td>
                        <td>return granted within time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&gwt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&gwt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?gwt=1">
                                webapi/hwm?gwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gbt</td>
                        <td>1</td>
                        <td>return granted beyond time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&gbt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&gbt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?gbt=1">
                                webapi/hwm?gbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rwt</td>
                        <td>1</td>
                        <td>return rejected within time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&rwt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&rwt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?rwt=1">
                                webapi/hwm?rwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rbt</td>
                        <td>1</td>
                        <td>return rejected beyond time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&rbt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&rbt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?rbt=1">
                                webapi/hwm?rbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pwt</td>
                        <td>1</td>
                        <td>return pending within time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&pwt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&pwt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?pwt=1">
                                webapi/hwm?pwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pbt</td>
                        <td>1</td>
                        <td>return pending beyond time application</td>
                        <td><a href="webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&pbt=1">
                            webapi/hwm?fromDate=2017-01-01&toDate=2017-08-01&pbt=1
                        </a>
                            <br>
                            <a href="webapi/hwm?pbt=1">
                                webapi/hwm?pbt=1
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!-- --------------------------------------------- HWM ends ----------------------------------------------->


    <!-- ----------------------------------------------- BMW ------------------------------------------------->
    <div class="row">
        <div class="row">
            <div class="col-md-12 text-center" style="background-color: lightgoldenrodyellow">
                <h3>BMW</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro" >
                Method
            </div>
            <div class="col-md-10">
                GET
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Description
            </div>
            <div class="col-md-10">
                Returns BMW Application data
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Link
            </div>
            <div class="col-md-10">
                <a href="webapi/bmw">webapi/bmw</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-2" style="background-color: gainsboro">
                Optional URL Params
            </div>
            <div class="col-md-10">
                <table class="table">
                    <tr>
                        <td>Name</td>
                        <td>Format/Value</td>
                        <td>Description</td>
                        <td>Example</td>
                    </tr>
                    <tr>
                        <td>fromDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>toDate</td>
                        <td>yyyy-mm-dd</td>
                        <td>used to filter count based on fromDate and toDate</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01
                        </a>
                        </td>
                    </tr>
                    <tr>
                        <td>ra</td>
                        <td>1</td>
                        <td>return received application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&ra=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&ra=1
                        </a>
                            <br>
                            <a href="webapi/bmw?ra=1">
                                webapi/bmw?ra=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gwt</td>
                        <td>1</td>
                        <td>return granted within time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&gwt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&gwt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?gwt=1">
                                webapi/bmw?gwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>gbt</td>
                        <td>1</td>
                        <td>return granted beyond time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&gbt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&gbt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?gbt=1">
                                webapi/bmw?gbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rwt</td>
                        <td>1</td>
                        <td>return rejected within time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&rwt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&rwt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?rwt=1">
                                webapi/bmw?rwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>rbt</td>
                        <td>1</td>
                        <td>return rejected beyond time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&rbt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&rbt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?rbt=1">
                                webapi/bmw?rbt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pwt</td>
                        <td>1</td>
                        <td>return pending within time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&pwt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&pwt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?pwt=1">
                                webapi/bmw?pwt=1
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>pbt</td>
                        <td>1</td>
                        <td>return pending beyond time application</td>
                        <td><a href="webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&pbt=1">
                            webapi/bmw?fromDate=2017-01-01&toDate=2017-08-01&pbt=1
                        </a>
                            <br>
                            <a href="webapi/bmw?pbt=1">
                                webapi/bmw?pbt=1
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!-- ------------------------------------------- BMW ends ----------------------------------------------->
</div>


</body>
</html>
