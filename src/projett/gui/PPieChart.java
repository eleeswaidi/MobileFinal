/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package projett.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.l10n.L10NManager;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;

import com.codename1.util.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import projett.entities.Produit;
import projett.services.ServicesProduit;

/**
 * Budget demo pie chart.
 */
public class PPieChart extends AbstractDemoChart {

    private List<Statis> listStatis = new ArrayList<Statis>();
    private int etap1 = 0;
    private int etap2 = 0;
    private int etap3 = 0;
   

    /**
     * Returns the chart name.
     *
     * @return the chart name
     */
    public String getName() {

        return "Statistique Promotions";
    }

    public void remplir() {

        ServicesProduit comdao = ServicesProduit.getInstance();
        List<Produit> ListCmd = comdao.AfficheProduit();
        for (Produit c : ListCmd) {

           
           
            Statis statis;
            if(c.getPromotion().getValeur()>=0){
            if (c.getPromotion().getValeur() == 20) {
                etap1++;
            } else if (c.getPromotion().getValeur() ==30) {
                etap2++;
            }else if (c.getPromotion().getValeur() ==50){
                etap3++;
            }

               
               
        }
        }
        if(etap1>0){
           Statis st=new Statis("Promotion 20%",etap1);
           listStatis.add(st);
        }

        if(etap2>0){
           Statis st=new Statis("Promotion 30%",etap2);
           listStatis.add(st);
        }
        
        if(etap3>0){
           Statis st=new Statis("Promotion 50%",etap3);
           listStatis.add(st);
        }
        
        
        
    }

    public int getRandomColor() {
        Random rnd = new Random();
        return ColorUtil.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (Statis s : listStatis) {

            series.add(StringUtil.replaceAll(s.getNom(),"Produits",""), s.getNombre());

        }
        return series;
    }

    /**
     * Returns the chart description.
     *
     * @return the chart description
     */
    public String getDesc() {
        return "Vue globale des produits et des promotions";
    }

    /**
     * Executes the chart demo.
     *
     * @param context the context
     * @return the built intent
     */
    public Form execute() {
        remplir();
        double[] values = new double[30];
        int[] colors = new int[30];
        Integer i = 0;
        for (Statis s : listStatis) {
            values[i] = (double) s.getNombre();
            i++;
        }
        Integer j = 0;
        for (Statis s : listStatis) {
            colors[j] = getRandomColor();
            j++;
        }

        final DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextFont(largeFont);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        renderer.setBackgroundColor(ColorUtil.rgb(243, 242, 242));
        renderer.setApplyBackgroundColor(true);
        renderer.setLabelsColor(0000);
        renderer.setLabelsTextSize(40);
        final CategorySeries seriesSet = buildCategoryDataset("Project budget", values);
        final PieChart chart = new PieChart(seriesSet, renderer);
        ChartComponent comp = new ChartComponent(chart);
        comp.setZoomEnabled(true);
    comp.setPanEnabled(true);
        return wrap("Statistique", comp);
        

    }

    public class Statis {

        private String nom;
        private int nombre;

        public Statis() {

        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getNombre() {
            return nombre;
        }

        public Statis(String nom, int nombre) {
            this.nom = nom;
            this.nombre = nombre;
        }

        public void setNombre(int nombre) {
            this.nombre = nombre;
        }

    }
}
