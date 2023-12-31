<h1>What is URL shortening</h1>

<h5>URL shortening is a technique on the internet in which a Uniform Resource Locator (URL) can be made substantially shorter and still direct you to the required page. This shorter URL makes it easier to distribute the link.

This is achieved by using a URL Shortening service/utility which takes the longer URL as input and generates a shorter URL for it. When the Short URL is used to open the webpage, the utility gets this request and redirects you to the web page of the corresponding longer URL.


For example, the URL "https://en.wikipedia.org/wiki/URL_shortening" can be shortened to "https://w.wiki/U" and the URL "https://example.com/assets/category_B/subcategory_C/Foo/" can be shortened to "https://example.com/Foo"
</h5>
-------------------------------
<p>
<h4>What are we building?</h4>
We will create a utility called Short URL, like bit.ly. This utility will create a short URL for a given longer URL and store it.

<h4>What features are we supporting?</h4>
<ul>
<li>generate a short URL for a given longUrl and return the short URL .( Create )</li>
<li>retrieve the longer URL based on the short URL ( Read )</li>
<li>remove the longUrl mapping that is currently tracked ( **Delete **)</li>
<li>custom shortUrl can be specified for a longUrl</li>
<li>Number of successful lookups for a longUrl (using getUrl())</li>
<li>The short URL could be one we've randomly generated or one specified by the user.</li>
</ul>
</p>

<h4>Scope of Work<h4>
<ul>
<li>Create a concrete class which implements a short URL interface class provided. It contains all the methods that can be used to create long URL to short URL mappings.</li>
<li>Implement a method to take a long URL as input, generate a random 9 character short URL and return it. Also maintain this mapping using a hash map for quick retrieval.</li>
<li>Implement a method to take a long URL and a custom short URL as input and register that mapping.</li> 
<li>Error handling to make sure each long URL maps to only one short URL and vice versa.</li>
<li>Implement a method to lookup short URL for a given long URL, from the mapping created.</li>
<li>Implement a method to delete the mapping based on a long URL.</li>
<li>Implement a counter to keep track of the hit count for each long URL - which tells us how many times a particular long URL has been looked up.</li>
<li>Test these methods using test cases.</li>
</ul>

<h4>Skills used</h4>
<h5>Core Java, Interfaces, Debugging</h5>