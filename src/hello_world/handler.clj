(ns hello-world.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as jetty]
            ))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn start-web []
  (jetty/run-jetty (-> #'app) {:port 8080}))

(defn -main [& args]
  (println "Hello, World!")
  (start-web)
  )