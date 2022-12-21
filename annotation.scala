import annotation._

class strategy(arg: Annotation) extends Annotation
class delayed extends Annotation

// @strategy(@delayed) def f () = {}
@strategy(new delayed) def f () = {}
