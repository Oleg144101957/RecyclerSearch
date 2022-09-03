package com.example.recyclersearch

import com.example.recyclersearch.model.Item

class ItemStorage {

    companion object{

        val list: ArrayList<Item> = ArrayList<Item>().apply {

            add(Item("РЕЦ", "Рецепт"))
            add(Item("НАР", "Направление на рентген"))
            add(Item("БОЛЛ", "Больничный лист"))
            add(Item("АКК", "Авалидная аккака"))
            add(Item("БУГ", "Бугага"))

            add(Item("ВОП", "Воооп по форме УД-34"))
            add(Item("СПОБ", "Справка о болезни (стандарт)"))
            add(Item("СПОБД", "Справка о болезни (детская)"))
            add(Item("СПИНВ", "Справка об инвалидности"))
            add(Item("СПСМ", "Справка о смерти"))

            add(Item("ЕНОТ", "Укус енота"))
            add(Item("СОБ", "Укус собаки"))
            add(Item("КОШКА", "Укус кошки"))
            add(Item("ЯЗЫК", "Повреждение языка"))
            add(Item("РУКА", "Перелом руки"))

            add(Item("НОГА", "Перелом ноги"))
            add(Item("РЕБР", "Перелом рёбер"))
            add(Item("ЧЕРЕП", "Перелом черепа"))

        }


    }


}