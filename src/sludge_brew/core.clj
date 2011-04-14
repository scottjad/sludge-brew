(ns sludge-brew.core
  (:use [compojure.core]
        [ring.adapter.jetty]
	[net.cgrand.moustache])
  (:require [sludge-brew.views.demo :as demo])
  (:gen-class))

(defn load-coffee-script
  "Loads a script from file"
  [script-name]
  (let [script-data (slurp (str "public/cs/" script-name))]
    {:status 200
     :headers {"Content-Type" "text/coffeescript;charset=UTF-8"}
     :body script-data}))

(def main-routes
     (app
      ["cs" script] {:get (fn [req] (load-coffee-script script))}
      [""] {:get demo/demo-page}))

(defn -main [& args]
  (run-jetty #'main-routes {:port 8080 :join? false})) 