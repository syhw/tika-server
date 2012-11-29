(defproject tika-server "1.0.0-SNAPSHOT"
  :description "listen on port 42042 and pass work to Tika"
  :dev-dependencies [[vimclojure/server "2.3.6"]]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-tika "1.2.0"]
                 [ring-server "0.2.5"]]
                  ;[ring/ring-core "1.1.6"]]
  :main "tika-server.core")
