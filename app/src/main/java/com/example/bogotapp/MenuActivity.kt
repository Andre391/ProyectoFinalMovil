package com.example.bogotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bogotapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.recycler.adapter = SitiosAdapter(
            listOf(
                Sitio("Plaza de Bolívar","plazabolivar","Está ubicada en el centro de la ciudad entre las carreras Séptima y Octava con calles Décima y Once, tiene una extensión aproximada de 13.903 metros cuadrados y una capacidad máxima para 55.600 personas. Esta histórica plaza, que ahora es el punto de encuentro de manifestantes y el lugar imperdible para turistas nacionales y extranjeros"),
                Sitio("Museo del Oro", "museo_oro","El Museo del Oro ubicado en el centro histórico de Bogotá es un espacio para conocer la historia del oro y otros metales en las sociedades prehispánicas y para aprender de la cultura"),
                Sitio("Jardin Botánico","jardinb","El Jardín Botánico de Bogotá lleva el nombre del astrónomo y botánico don José Celestino Mutis. Él fue el primero en consagrarse de lleno al estudio de las ciencias naturales en el territorio de la Nueva Granada"),
                Sitio("Museo Nacional","museo_nal","El Museo Nacional de Colombia fue creado en 1823, y es uno de los más antiguos de América. Ofrece a sus visitantes diecisiete salas de exposición permanente, en las cuales se exhiben alrededor de 2.500 obras y objetos, símbolos de la historia y el patrimonio nacional"),
            ),
            object : SitioClickedListener {
                override  fun onSitioClickList(sitio: Sitio){
                    Toast.makeText(this@MenuActivity,sitio.nombre, Toast.LENGTH_LONG).show()
                }

            }
        )
    }
}
