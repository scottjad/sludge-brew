(ns sludge-brew.views.demo
  (:use [sludge-brew.views.core]
        sludge-brew.draw
        slice.core
	[hiccup core page-helpers]
	[ring.util.response]))

(slice demo-page
  draw
  (title "Demo")
  (html [:div#main
         [:canvas#processing]]))
