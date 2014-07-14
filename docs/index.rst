.. ElasticSearch Tutorials documentation master file, created by
   sphinx-quickstart on Mon Jul  7 08:39:15 2014.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to ElasticSearch Tutorials's documentation!
===================================================

Contents:

.. toctree::
   :maxdepth: 2

Download `Elastic Search <https://download.elasticsearch.org/elasticsearch/elasticsearch/elasticsearch-1.2.2.zip>`_ 

Unzip it: unzip elasticsearch-1.2.2.zip

Start it: 
 cd elasticsearch-1.2.2 && bin/elasticsearch

Check its running, by going to http://localhost:9200/

Download and run the `Sample page indexer <https://github.com/johnjoeallen/ElasticSeachTutorials/blob/master/src/>`_ 

You will need the .groovy file and a feed.txt to specify the URLs to index. You will need Groovy installed on your machine, 
if you don't have it, you can get it via `gvm <http://gvmtool.net/>`_ on Linux or `gravy <https://github.com/enterprise-grails/gravy>`_ on Windows. 

Now you can run some queries:

http://localhost:9200/pgindex/page/_search?q=text:software

http://localhost:9200/pgindex/page/_search?q=text:analytical

Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`

