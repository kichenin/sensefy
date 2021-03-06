Sensefy

Leveraging enterprise information is no easy task

Especially when unstructured information represents more than 80% of enterprise content.
Meaningfully structuring content is critical for companies, Natural Language Processing and Semantic Enrichment
is becoming increasingly important to improve the quality of tasks related to information retrieval.



    "angularjs-slider": "~0.1.6",
        "ng-pdfviewer": "~0.2.1",
        "pdfjs-dist": "~1.1.28",







    <!doctype html>
    <!--[if lt IE 7]>
    <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
    <!--[if IE 7]>
    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
    <!--[if IE 8]>
    <html class="no-js lt-ie9"> <![endif]-->
    <!--[if gt IE 8]><!-->
    <html class="no-js">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>Sensefy Boot Search</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <!-- build:css styles/vendor.css -->
        <!-- bower:css -->
        <!-- endbower -->
        <!-- endbuild -->
        <!--link rel="stylesheet" href="../bower_components/semantic/dist/semantic.min.css" -->
        <!-- build:css({.tmp,app}) styles/main.css -->
        <link href='//fonts.googleapis.com/css?family=Lato:700,400' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../bower_components/semantic/dist/semantic.min.css">
        <link rel="stylesheet" href="assets/styles/master.css">
        <link rel="stylesheet" href="assets/styles/devices.css">
        <!-- endbuild -->
        <base href="/">
    </head>
    <body ng-app="SensefySemanticSearch" ng-cloak class="ng-cloak" id="sensefy" ng-controller="RootController">
    <!--[if lt IE 7]>
    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
        your browser</a> to improve your experience.</p>
    <![endif]-->

    <div class="ui page grid wrapper" ng-view>

    </div>
    <div ng-include="'views/layout/footer.html'"></div>


    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID -->
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o), m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script',
                '//www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-XXXXX-X');
        ga('send', 'pageview');
    </script>


    <!-- build:js scripts/vendors.js -->
    <!-- bower:js -->
    <script src="../bower_components/es5-shim/es5-shim.js"></script>
    <script src="../bower_components/jquery/dist/jquery.js"></script>
    <script src="../bower_components/angular/angular.js"></script>
    <script src="../bower_components/angular-mocks/angular-mocks.js"></script>
    <script src="../bower_components/semantic/dist/semantic.js"></script>
    <script src="../bower_components/angular-semantic-ui/dist/angular-semantic-ui.js"></script>
    <script src="../bower_components/angular-semantic-ui/dist/angular-semantic-ui.min.js"></script>
    <script src="../bower_components/json3/lib/json3.min.js"></script>
    <script src="../bower_components/angular-resource/angular-resource.js"></script>
    <script src="../bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="../bower_components/angular-sanitize/angular-sanitize.js"></script>
    <script src="../bower_components/angular-route/angular-route.min.js"></script>
    <script src="../bower_components/angular-animate/angular-animate.js"></script>
    <script src="../bower_components/jstzdetect/jstz.min.js"></script>
    <script src="../bower_components/angular-translate/angular-translate.js"></script>
    <script src="../bower_components/messageformat/messageformat.js"></script>
    <script src="../bower_components/angular-translate-interpolation-messageformat/angular-translate-interpolation-messageformat.js"></script>
    <script src="../bower_components/angular-dynamic-locale/src/tmhDynamicLocale.js"></script>
    <script src="../bower_components/angular-local-storage/dist/angular-local-storage.js"></script>
    <script src="../bower_components/angular-utils-pagination/dirPagination.js"></script>
    <script src="../bower_components/moment/moment.js"></script>
    <script src="../bower_components/angular-moment/angular-moment.js"></script>
    <script src="../bower_components/d3/d3.js"></script>
    <script src="../bower_components/ng-pdfviewer/ng-pdfviewer.js"></script>
    <script src="../bower_components/pdfjs-dist/build/pdf.js"></script>
    <script src="../bower_components/pdfjs-dist/build/pdf.worker.js"></script>
    <!-- endbower -->
    <!-- endbuild -->



    <!-- build:js scripts/main.js-->
    <script src="assets/scripts/auth/auth.js"></script>
    <script src="assets/scripts/configuration/main.js"></script>
    <script src="assets/scripts/controllers/main.js"></script>
    <script src="assets/scripts/directives/main.js"></script>
    <script src="assets/scripts/filters/main.js"></script>
    <script src="assets/scripts/services/main.js"></script>
    <script src="assets/scripts/x/main.js"></script>
    <script src="assets/scripts/x/interactions.js"></script>
    <!-- endbuild -->
    </body>
    </html>
