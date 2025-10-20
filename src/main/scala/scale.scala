package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(s: Shape, factor: Double): Shape =
    def round(d: Double): Int = Math.round(d).toInt

    s match
      case Rectangle(w, h) => Rectangle(round(w * factor), round(h * factor))
      case Ellipse(rx, ry) => Ellipse(round(rx * factor), round(ry * factor))
      case Location(x, y, inner) => Location(round(x * factor), round(y * factor), apply(inner, factor))
      case Group(ss) => Group(ss.map(apply(_, factor)))

end scale

