(ns sludge-brew.views.demo
  (:use [sludge-brew.views.core]
	[hiccup core page-helpers]
	[ring.util.response]))

(defn demo-page [req]
  {:status 200
   :body (html-doc "Demo"
	     [:h1 "Hello " [:span {:id "message"}]])})
  

