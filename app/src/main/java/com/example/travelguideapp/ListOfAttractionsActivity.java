package com.example.travelguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class ListOfAttractionsActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private Button tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_attractions);

        textView = findViewById(R.id.textView5);
        User user = getIntent().getParcelableExtra("user");
        textView.setText("Здравствуйте, " + user.getName() + "!");


        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Тыл - фронту", "Монумент памяти Великой Отечественной войны в городе Магнитогорске. Авторы: скульптор — Лев Николаевич Головницкий, архитектор — Яков Борисович Белопольский. Материал — бронза, гранит. Монумент открыт 28—29 июня 1979 года.", new Point(53.407217, 58.992405), "hystory", 0.125));
        attractions.add(new Attraction("Арена Металлург", "Ледовый дворец спорта в городе Магнитогорске. Вместимость 7700 зрителей. Расположен в прибрежно-парковой зоне правобережной части. В ЛДС с 2007 года проводит домашние матчи хоккейная команда «Металлург».", "9:00 - 18:00", new Point(53.381552, 58.992268), "sport", 0.25));
        attractions.add(new Attraction("Палатка первых строителей Магнитки", "памятник при входе в Парк Ветеранов города Магнитогорска, который был открыт 9 мая 1966 года. Памятник состоит из двух скульптур, это, собственно, «Первая палатка» и рука, держащая кусок железной руды. «Первая палатка» символически изображает палатку, где в 1930-е годы жили первые строители города.", new Point(53.4259213, 58.99773), "hystory", 0.05));
        attractions.add(new Attraction("Кафедральный собор Вознесения Господня", "православный храм в городе Магнитогорске Челябинской области, кафедральный собор Магнитогорской епархии Русской православной церкви.", new Point(53.380138,  58.998281), "hystory", 0.125));
        attractions.add(new Attraction("Аквапарк \"Водопад чудес\"", "единственный в Южно-Уральском регионе водно-развлекательный комплекс европейского уровня, построенный ведущими специалистами из Германии, Австрии, Польши и России.", "10:00 - 18:00", new Point(53.413084, 58.991513), "sport", 0.1));
        attractions.add(new Attraction("МАУК \"Магнитогорский драматический театр им. А. С. Пушкина\"", "старейший театр города Магнитогорска. История театра уходит своими корнями в историю города, когда в 1931 году на базе агитбригады был создан Магнитогорский театр рабочей молодёжи.", new Point(53.411225, 58.982954), "hystory", 0.1));
        attractions.add(new Attraction("Магнитогорская картинная галерея", "единственный художественный музей в Магнитогорске.\n" +
                "Даем вам возможность общаться с прекрасным и обогащать духовный мир!\n" +
                "Сохраняем произведения изобразительного искусства! Показываем 30 разнообразных выставок в год!", new Point(53.408324, 58.981488), "hystory", 0.02));
        attractions.add(new Attraction("Экологический парк", "В зимнее время года в парке прокладывается лыжня различной протяженности и открывается каток с хоккейной площадкой, где Вы можете провести время со своими друзьями.\n" +
                "А летом Вас ждут специально оборудованные спортивные и детские площадки, полоса препятствий, лыже-роллерная трасса и, конечно, уютные кафе, где Вы можете отдохнуть и расслабиться.", new Point(53.404966, 58.949614), "sport", 0.125));
        attractions.add(new Attraction("Центральный Стадион", "крупнейший стадион в Магнитогорске. Домашний клуб — Металлург-Магнитогорск. Построен в 1967 году. С 2015 по 2017 была проведена реконструкция", new Point(53.411154, 58.991091), "sport", 0.1));
        attractions.add(new Attraction("Куранты", "Проект курантов был создан архитектором Пономаревым. По его замыслу нижнюю часть башни должны были украшать четыре скульптуры символизирующие времена года. Для реализации проекта были приглашены лучшие инженеры-конструкторы из службы механизации ММК. Циферблат был разработан Геннадием Шастиным. Но с самого начала все пошло не так, как задумывалось. Скульптуры так и не были изготовлены, а часы после открытия сначала показывали неправильное время, а потом и вовсе перестали ходить.", "9:30 - 18:00", new Point(53.406983, 58.979376), "hystory", 0.2));

        listView = findViewById(R.id.listView);
        ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attractions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(ListOfAttractionsActivity.this, AttractionActivity.class);
                intent.putExtra("attraction", attractions.get(position));
                startActivity(intent);
            }
        });

        tour = findViewById(R.id.tourButton);

        tour.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfAttractionsActivity.this, TourActivity.class);
            intent.putParcelableArrayListExtra("attractions", attractions);
            startActivity(intent);
        });
    }
}
