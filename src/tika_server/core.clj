(ns tika-server.core
  (:require [tika]
            [clojure.string :as s])
  (:import [java.net URLDecoder])
  (:use [ring.server.standalone]
        [cheshire.core])
  (:gen-class))


(defn handler 
  [request]
  (let [url (URLDecoder/decode (:query-string request))]
    (try 
      {:status 200
       :headers {"Content-Type" "application/json"}
       :body (generate-string {:status "success",
                               :retval (:text (tika/parse url))})
       }
      (catch Exception e 
        {:status 400, 
         :headers {"Content-Type" "application/json"}
         :body (generate-string {:status "failure",
                                 :reason (str "here is your url: " url 
                    " and error message: " (.getMessage e))})
         }))))

(defn -main [& args]
  (serve handler {:port 9998}))

