(ns sludge-brew.core
  (:use [compojure.core]
        [ring.adapter.jetty]
	[net.cgrand.moustache])
  (:require [sludge-brew.views.demo :as demo])
  (:gen-class))

(def main-routes
     (app
      [""] {:get demo/demo-page}))

(defn -main [& args]
  (run-jetty #'main-routes {:port 8080 :join? false})) 