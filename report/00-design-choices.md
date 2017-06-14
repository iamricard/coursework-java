# Design Choices

I've made some choices for this solution that require some justification. The
project guidelines suggested using the Java [Swing] framework, which was meant
to be replaced by [JavaFX]. However, both technologies are quite outdated. The
former is partially deprecated and the latter doesn't appear to be well
maintained, documentation is scarce, and Oracle has discontinued support for
the editor tools. After some research I came to the conclusion that, as of June
2017, the community has pivoted towards using Java for the business logic and
persistence through a web server, while leaving the templating and UI sections
to a much more mature and seasoned technology: the HTML, CSS, and JavaScript
triad.

In this particular project, the server is built on the shoulders of the Java
bindings to the [Play] framework (see footnote for more information). The
persistence layer is built on Java's [Ebean] targeting a [PostgreSQL] backend.
For deployment, I used [Heroku] and integrated it with Github[^1] for automated
deployments.

In the following chapter I will elaborate on the core pieces of the application.

[Swing]: https://www.wikiwand.com/en/Swing_(Java)
[JavaFX]: https://www.wikiwand.com/en/JavaFX
[Play]: https://playframework.com
[Ebean]: http://ebean-orm.github.io/
[PostgreSQL]: https://www.postgresql.org
[Heroku]: https://heroku.com
[^1]: https://devcenter.heroku.com/articles/github-integration
