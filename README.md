# Sensefy Features

Sensefy is a **Enterprise Semantic Search** Engine developed by Zaizi. Built on top of cutting edge open source software, it will provide the users with advanced enterprise search functionalities.

Sensefy is **Semantic** because it enriches the documents semantically to extract entities such as people, organizations and places and improve the Search user experience by giving semantic search functionalities.

Sensefy is **Enterprise** because it offers federated search, allowing the user to index the content from heterogeneous data sources, search all of them from a unified search endpoint keeping ACLs of the documents to allow only permitted users to access relevant documents.

With MICO integration Sensefy allows user to search across different media types such as text, audios and videos with a single query

## Project Structure

Sensefy consists of the following components:

 - Sensefy-UI : An AngularJS based responsive search user interface 
 - Sensefy-API : Spring-Boot based Sensefy API consists of secure Restful API to communicate between Sensefy UI and backend components such as Solr and ManifoldCF
 - Sensefy Authentication Server : Sensefy Auth Server uses OAuth2 to authenticate the applications and helps the other application to communicate securely by using Single Sign On
 - Sensefy-Runner : Runner project to build and run all in one, downloading the dependent components in Sensefy  and configuring Sensefy to run as a maven command
 - Dataprocessing API - Spring-boot based application for injecting MICO analyzed metadata to Sensefy backend

## Sensefy Dependencies

Sensefy uses several open-source projects under the hood. Following are the open source projects currently integrated in Sensefy:

- Apache ManifoldCF 2.3 : 
    Framework for connecting to and crawling content and security policies from source repositories. ManifoldCF supports a large number of repositories. Full list of supported repositories can be found online at : http://manifoldcf.apache.org/en_US/release-documentation.html. 

- Apache Solr 5.3.1 : Search server to index and query content. The Solr project site can be accessed here : http://lucene.apache.org/solr/


## Build and Run Sensefy

You can find a detailed guide on how to build and run sensefy with all it's dependencies in the How_To_Run_Sensefy.pdf in the repository root. 

You can also follow below instructions to get started with Sensefy.

#####  Prerequisites
* Java 1.8  
* Maven 3.2 or higher
* Alfresco 5.0.1 (Currently tested on Enterprise Edition only)

#### Install and configure Alfresco
Currently Sensefy Application is tested with Alfresco 5.0.1 Enterprise Edition as the authentication provider. Download 30 days trail of Alfresco from http://alfresco.com
. Refer the document provided by Alfresco to install Alfresco ECM http://docs.alfresco.com/5.0/concepts/ch-install.html

#### Build and Apply Alfresco Indexer Webscript
```
1. Clone the repository alfresco-indexer : https://github.com/zaizi/alfresco-indexer
2. Build alfresco-indexer-webscripts project 
3. Copy alfresco-indexer-webscripts.amp file to amps directory in Alfresco
4. Run bin/apply_amps.sh from Alfresco Installation directory to apply the amp
```

#### Build and Run only Sensefy Application

Use the below command to run executable JAR with only Sensefy Application(Sensefy API, Sensefy UI and Sensefy Auth Server). In this you have to manually install and configure Manifold and Solr to work with Sensefy API

##### Build JAR

```sh 
mvn clean install -Pbuild-frontend,war,build-jar -Dmaven.test.skip=true
```

Once the build succeeded, navigate to "sensefy-runner" and then target.  Inside the target folder there going to be a executable JAR **"sensefy-<sensefy.version}>.jar"** (Eg : sensefy-2.0.1.jar)
java  -jar sensefy-2.0.1.jar

After this execution, Sensefy URLs will be available as below:

    http://localhost:9099/ : SearchUI
    http://localhost:9099/api/ : SearchAPI
    http://localhost:9099/auth/ : SearchAuth

#### Build and Run All-in-one (Only works with Access to Zaizi Repo)

Build Sensefy API, Sensefy UI , Sensefy Auth Server and run with ManifoldCF 2.3 and Solr 5.3 in a single maven command.

##### Sensefy Configuration Properties 
Before building the Runner project, please ensure following application.properties are defined for Sensefy Auth-Server and Sensefy-API to connect to Alfresco for authentication. 

Following properties will connect Sensefy to local Alfresco for authentication and to retrieve user permissions.

* Sensefy Auth Server 

        sensefy.authentication.alfresco.endpoint=http://localhost/alfresco

        sensefy.manifold.authority.endpoint=http://localhost:9099/mcf-combined-service


* Sensefy API

        spring.oauth2.resource.userInfoUri=http://localhost:9099/auth/user


#####  Maven Build 
Execute the below command in the 
```sh
mvn clean install -Dmaven.test.skip=true
mvn clean install -Prun  -Dmaven.test.skip=true
```

After this execution, next URLs will be available:

* http://localhost:9099/ : SearchUI
* http://localhost:9099/api/ : SearchAPI
* http://localhost:9099/auth/ : SearchAuth
* http://localhost:9099/solr/#/ : Solr
* http://localhost:9099/mcf-combined-service : ManifoldCF

#### Build and run Dataprocessing API

```
cd dataprocessingAPI
mvn clean install -DskipTests
cd target
cp -R ../config config/
java -jar dataprocessingAPI-0.0.1-SNAPSHOT.jar
```

##### Accessing the Search UI
You can access the Sensefy UI at http://localhost:9099/

The pre-built Sensefy binary is configured to use Alfresco as the authentication provider, and points to the local Alfresco endpoint (http://localhost/alfresco) for authentication.
Therefore please provide user credentials of an Alfresco user to login to Sensefy. Once logged in you will be directed to the Sensefy Search UI where you can perform **'Search'**.

##### Accessing the ManifoldCF UI
Apache ManifoldCF is used in Sensefy as the content crawler. You can access the ManifoldCF UI at http://localhost:8345/mcf-crawler-ui . 
We have pre-configured 2 ManifoldCF jobs for your convenience.

* Alfresco Solr connection : connects to the local Alfresco instance, extracts documents and index them in local Solr
* Alfresco Stanbol connection : connects to the local Alfresco instance, extracts documents and enhance documents semantically by tagging entities and them in local Solr

##### Accessing the Solr UI

Apache Solr is used in Sensefy as the search engine and indexer. You can access the Solr UI at http://localhost:8983/solr/

In the Solr, your documents are indexed in PrimaryIndex core. The extracted entities and entityTypes in the documents are indexed in Entity and EntityType cores.


#### Copyright


© Zaizi Limited. Code for this plugin is licensed under the GNU Lesser General Public License (LGPL).

Any trademarks and logos included in these plugins are property of their respective owners and should not be reused, redistributed, modified, repurposed, or otherwise altered or used outside of this plugin.
