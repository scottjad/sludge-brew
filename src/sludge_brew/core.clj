(ns sludge-brew.core
  (:use [compojure.core]
        [ring.adapter.jetty]
	[net.cgrand.moustache]
    slice.core)
  (:require [sludge-brew.views.demo :as demo])
  (:gen-class))

(def main-routes
     (app
      [""] (render demo/demo-page)))

(defn -main [& args]
  (run-jetty #'main-routes {:port 8080 :join? false})) 