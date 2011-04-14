;; ## Core View
;; Standard page layout
(ns sludge-brew.views.core
  (:use [hiccup core page-helpers]))

(defn- include-coffee-script
  "Include a list of external coffee-script scripts."
  [& scripts]
  (for [script scripts]
    [:script {:type "text/coffeescript", :src (resolve-uri script)}]))

(defn html-doc [title & body]
    (html
     (doctype :html4)
     [:html
      [:head
       [:title title]
       (include-js "http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
		   "http://jashkenas.github.com/coffee-script/extras/coffee-script.js"
		   "http://processingjs.org/content/download/processing-js-1.0.0/processing-1.0.0.min.js"
		   "http://documentcloud.github.com/underscore/underscore.js")
       (include-coffee-script "cs/coffee_draw.coffee")]
      [:body
       body]]))