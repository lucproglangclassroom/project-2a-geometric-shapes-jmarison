package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  import scala.math.{min, max}

  def apply(s: Shape): Location =
    // returns Location(xmin, ymin, Rectangle(width, height))
    def bbox(sh: Shape): (Int, Int, Int, Int) = sh match
      case Rectangle(w, h) => (0, 0, w, h)
      case Ellipse(rx, ry) => (-rx, -ry, rx * 2, ry * 2)
      case Location(x, y, inner) =>
        val (ix, iy, iw, ih) = bbox(inner)
        (x + ix, y + iy, iw, ih)
      case Group(ss) if ss.isEmpty => (0, 0, 0, 0)
      case Group(ss) =>
        val bboxes = ss.map(bbox)
        val xs = bboxes.map(_._1)
        val ys = bboxes.map(_._2)
        val ws = bboxes.map(_._3)
        val hs = bboxes.map(_._4)
        val xmins = xs
        val ymins = ys
        val xmaxs = (xs zip ws).map((x, w) => x + w)
        val ymaxs = (ys zip hs).map((y, h) => y + h)
        val xmin = xmins.min
        val ymin = ymins.min
        val xmax = xmaxs.max
        val ymax = ymaxs.max
        (xmin, ymin, xmax - xmin, ymax - ymin)

    val (x, y, w, h) = bbox(s)
    Location(x, y, Rectangle(w, h))

end boundingBox
