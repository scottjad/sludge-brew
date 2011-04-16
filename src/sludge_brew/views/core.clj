;; ## Core View
;; Standard page layout
(ns sludge-brew.views.core
  (:use [hiccup core page-helpers]
        slice.core))

(slice html-doc [title & body]
  (doctype :html4)
  (title title)
  jquery
  (head (include-js "http://processingjs.org/content/download/processing-js-1.0.0/processing-1.0.0.min.js"
                    "http://documentcloud.github.com/underscore/underscore.js"))
  (html body))