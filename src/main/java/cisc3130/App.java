package cisc3130;

import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.*;
import java.io.*;
import java.util.*;

public class App {
    public static void main( String[] args ) throws FileNotFoundException, java.io.IOException  {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(2);


        final java.util.List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("One_More_Time.txt");

        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("head.png"));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        wordCloud.setBackgroundColor(new Color(0x000000));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xc4c507)));


        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("wordcloud.png");
    }
}