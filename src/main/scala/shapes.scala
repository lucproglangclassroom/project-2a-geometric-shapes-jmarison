package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) | Ellipse(rx, ry) | Group(shapes*) */
sealed trait Shape derives CanEqual

object Shape:
  final case class Rectangle(width: Int, height: Int) extends Shape:
    require(width >= 0 && height >= 0, s"Rectangle dimensions must be non-negative: $width x $height")

  final case class Location(x: Int, y: Int, shape: Shape) extends Shape

  final case class Ellipse(rx: Int, ry: Int) extends Shape:
    require(rx >= 0 && ry >= 0, s"Ellipse radii must be non-negative: $rx x $ry")

  final case class Group(shapes: Seq[Shape]) extends Shape

  object Group:
    import scala.annotation.targetName
    @targetName("applyVarargs")
    def apply(shapes: Shape*): Group = Group(shapes.toSeq)

