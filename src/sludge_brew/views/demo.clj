(ns sludge-brew.views.demo
  (:use [sludge-brew.views.core]
	[hiccup core page-helpers]
	[ring.util.response]))

(defn demo-page [req]
  {:status 200
   :body (html-doc "Demo"
		   [:div {:id "main"}
		    [:canvas {:id "processing"}]])})
  

