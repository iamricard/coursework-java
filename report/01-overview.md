# Overview

Project is setup using the Java [Play] framework to aid with following the [MVC]
pattern.

## Models

From Wikipedia:

> _The model is the central component of the pattern. It expresses the
> application's behavior in terms of the problem domain, independent of the
> user interface. It directly manages the data, logic and rules of the
> application._

All the models used by this application are stored in [PostgreSQL]. The bindings
are done through [PlayEbean].

### Option

`Option` is the smallest model. It has a [one-to-many] relationship to
[`Question`](#question), where one `Question` can have `n Option`s, and each
`Option` belongs to `1 Question`.

In essence it's an alias to a `String` type, the only difference is that
`Option` has a `Long id` and a `Question question`.

See [models/Option.java] for implementation.

### Question

`Question` is, arguably, the meat of the application. It holds _many_ `Option`s
as a `List<Option>`, along with other parameters like difficulty, type, and
category or the `Quiz` it belongs to. Like `Option`, `Question` holds a
[one-to-many] relationship to  [`Quiz`](#quiz). Except in this case `n
Question`s belong to `1 Quiz`.

See [models/Question.java] for implementation.

### Quiz

This is the model that is actually used by other parts of the application. The
rest are intermediary models to store data in a way that makes it easier to
manipulate. `Quiz` owns two different models, `QuizResult` and `Question`. Any
`Quiz` may have any number of `QuizResult`s and `Question`s.

It also has a `String difficulty` value which ranges from _easy_ to _hard_, or
_mixed_. Also provides a method int `computeScore(DynamicForm answers)` to
compute the score from a form submission.

See [models/Quiz.java] for implementation.

### QuizResult

`QuizResult` is how the application stores the return value of `int
computeScore(DynamicForm answers)` in `Quiz`. This is to allow sharing and
retaking the `Quiz`, hence the belonging relationship.

See [models/QuizResult.java] for implementation.

## Services

From [SWE SX]:

> _Services normally return DTOs in large applications or domain models directly
> in smaller applications. DTOs normally means more work, but better separation
> of concerns. The typical flow is: Controller calls service →
> Service returns an object (be it a DTO, domain model or something else) →
> Controller maps DTO/domain model to a view model_.

### QuizService

The service layer in this case abstracts the added complexity of calling the
[Open Trivia DB] API. It makes a request to the API with modifiers such as
`String amount` and `String difficulty`, and then returns a [`Quiz`](#quiz)
Ebean.

See [services/QuizService.java] for implementation.

## Controllers

From Wikipedia:

> _The controller accepts input and converts it to commands for the model or
> view._

### QuizResultsController

This controller handles requests that ask for a specific result, as well as
creating new results. The former is via the `Result show(UUID id)` method; the
latter is via the `Result create()` method.

See [controllers/QuizResultsController.java] for implementation.

### QuizzesController

This controller is the meatiest one. It renders a form with `Result form()`,
handles the result of said form in `CompletionStage<Result> create()` and
displays an existing `Quiz` via `Result show(UUID id)`.

See [controllers/QuizzesController.java] for implementation.

[Play]: https://playframework.com
[MVC]: https://www.wikiwand.com/en/Model%E2%80%93view%E2%80%93controller
[PostgreSQL]: https://www.postgresql.org/
[PlayEbean]: https://www.playframework.com/documentation/2.5.x/JavaEbean
[one-to-many]: https://www.wikiwand.com/en/One-to-many_(data_model)
[models/Option.java]: https://git.io/vHdem
[models/Question.java]: https://git.io/vHde6
[models/Quiz.java]: https://git.io/vHdvZ
[models/QuizResult.java]: https://git.io/vHdvn
[SWE SX]: https://softwareengineering.stackexchange.com/a/211724
[Open Trivia DB]: https://opentdb.com/
[services/QuizService.java]: https://git.io/vHdkc
[controllers/QuizResultsController.java]: https://git.io/vHdks
[controllers/QuizzesController.java]: https://git.io/vHdkn
