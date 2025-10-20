package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, inner) => 1 + apply(inner)
    case Group(ss) if ss.isEmpty => 0
    case Group(ss) =>
      val childHeights = ss.map {
        case Location(_, _, inner) => apply(inner)
        case other => apply(other)
      }
      1 + childHeights.max

end height

