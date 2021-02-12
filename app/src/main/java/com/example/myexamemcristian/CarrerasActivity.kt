package com.example.myexamemcristian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_carreras.*

class CarrerasActivity : AppCompatActivity() {
    var adapterCarreras: ListCarreraAdapter? = ListCarreraAdapter()
    var listProductos = mutableListOf<Carreras>()
    var rcList :RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carreras)
        setData()

        rcList = findViewById(R.id.rc_list)
        rcList?.apply {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@CarrerasActivity)
            setHasFixedSize(true)
            setItemViewCacheSize(20)
            adapter = adapterCarreras
        }

        adapterCarreras?.setCursos(listProductos)

        btn_graficos.setOnClickListener {
            val intent = Intent(this, GraficosActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setData() {
        listProductos.add(
            Carreras(
                "Administración de Empresas",
                "La Carrera Profesional de Administración de Empresas de la UNTELS, está orientada a ser líder en el sistema universitario peruano con el objeto de generar los cambios organizacionales que propendan a elevar la calidad de vida de la sociedad. Además busca contribuir al desarrollo integral de los estudiantes mediante el estudio de las ciencias y técnicas de vanguardia, para lograr en los estudiantes, una formación profesional altamente competitivos de acuerdo a las exigencias y requerimientos de la sociedad peruana.",
                R.drawable.esc_administracion
            )
        )
        listProductos.add(
            Carreras(
                "Ingeniería Ambiental",
                "La carrera de Ingeniería Ambiental estudia, investiga, interpreta los fenómenos naturales y la problemática ambiental para generar soluciones sostenibles mediante una razonable aplicación de la ciencia y la tecnología que permitan prevenir, controlar, mitigar sus impactos y la gestión necesaria para su conservación y mejoramiento.",
                R.drawable.esc_ambiental
            )
        )
        listProductos.add(
            Carreras(
                "Ingeniería de Sistemas",
                "En Ingeniería de Sistemas buscamos formar profesionales con calidad técnica-científica, humana y de responsabilidad social, para desempeñarse en el contexto regional, nacional e internacional. Con aptitudes de inteligencia emocional y valorativa, así mismo estarán capacitados en investigación científica y tecnología aplicada, así como en capacidades productivas. También buscamos ser una carrera profesional líder, reconocida por su excelencia académica, científica y por el desarrollo e innovación tecnológica permanente, contribuyendo al desarrollo económico y social de la región y del país.",
                R.drawable.esc_sistemas
            )
        )
        listProductos.add(
            Carreras(
                "Ingeniería Electrónica y Telecomunicaciones",
                "Se busca formar profesionales en el área de ingeniería electrónica y telecomunicaciones, con calidad técnica-científica, humana y de responsabilidad social, para desempeñarse en el contexto regional, nacional e internacional. Con aptitudes de inteligencia emocional y valorativa, así mismo estarán capacitados en investigación científica y tecnología aplicada, así como en capacidades productivas. Además ser reconocida por su excelencia académica, científica y por el desarrollo e innovación tecnológica permanente, contribuyendo al desarrollo económico y social de la región y del país.",
                R.drawable.esc_electronica
            )
        )
        listProductos.add(
            Carreras(
                "Ingeniería Mecánica y Eléctrica\n",
                "El ingeniero mecánico electricista, egresado de la Untels, diseña, construye, instala y dirige. Mantiene, controla e innova sistemas destinados a la generación, transformación, transmisión y aprovechamiento de la energía eléctrica en todas sus aplicaciones.",
                R.drawable.esc_mecanica
            )
        )
    }

}

data class Carreras(
    val name: String? = null,
    val desc: String? = null,
    val img: Int? = null
)