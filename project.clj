(defproject sludge-brew "1.0.0-SNAPSHOT"
  :description "coffee script + jQuery + clojure + compojure + hiccup + cssgen"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [compojure "0.6.2"]
		 [ring "0.3.7"]
		 [net.cgrand/moustache "1.0.0"]
		 [hiccup "0.3.0"]
		 [cssgen "0.2.4"]]
  :dev-dependencies [[swank-clojure "1.3.0-SNAPSHOT"]
		     [marginalia "0.5.0"]]
  :main sludge-brew.core
  :aot [sludge-brew.core])
