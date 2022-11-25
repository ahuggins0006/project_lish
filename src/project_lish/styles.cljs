(ns project-lish.styles
  (:require-macros
    [garden.def :refer [defcssfn]])
  (:require
    [spade.core   :refer [defglobal defclass]]
    [garden.units :refer [deg px]]
    [garden.color :refer [rgba]]))

(defglobal defaults
  [:body
   {:color               :purple
    :background-color    :white
    }])

(defclass level1
  []
  {:color :green})
