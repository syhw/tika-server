(ns tika-server.core
  (:require [tika]
            [clojure.string :as s])
  (:import [java.net URLDecoder])
  (:use [ring.server.standalone]
        [cheshire.core]
  (:gen-class)))

(defn clean-text
  " Removes \n \t and html fields that passed through tika (#{header}...) "
  [text]
  (s/replace (s/replace 
               (s/replace text #"\n" " ") #"\t" " ") #"#\{[^}]*\}" " "))

(defn handler 
  [request]
  (let [query (URLDecoder/decode (:query-string request))
        parts (s/split query #"=" 2)
        url   (nth parts 1)
       ]
    (try 
      {:status 200
       :headers {"Content-Type" "application/json"}
       :body (generate-string {:status "success",
                               :retval (clean-text (:text (tika/parse url)))})
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

