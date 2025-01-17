/*
 * Copyright 2019 Sven Schoradt (s.schoradt@infotec-edv.de).
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
package de.schoradt.adventofcode.year2019;

import de.schoradt.adventofcode.BaseDay;
import de.schoradt.adventofcode.year2019.data.Raster;

import java.util.List;

/**
 *
 * @author Sven Schoradt (s.schoradt@infotec-edv.de)
 */
public class Day10 extends BaseDay {
    public record Location(boolean asteroid) {}

    public int bestAsteroidViewCount(List<String> lines) {
        int count = Integer.MIN_VALUE;

        Raster<Location> raster = createRaster(lines);

        //raster.print();

        for (int i = 0; i < raster.getWidth(); i++) {
            for (int j = 0; j < raster.getHeight(); j++) {
                if (raster.get(i, j) != null) {
                    int views = computeViews(raster, i, j);

                    //System.out.println("views (" + i + ", " + j + ") " + views);

                    count = Math.max(views, count);
                }
            }
        }

        return count;
    }

    private int computeViews(Raster<Location> raster, int x, int y) {
        int views = 0;

        for (int i = 0; i < raster.getWidth(); i++) {
            for (int j = 0; j < raster.getHeight(); j++) {
                if (raster.get(i, j) != null && !(i == x && j == y)) {
                    if (raster.isViewable(x, y, i, j)) {
                        views++;
                    }
                }
            }
        }

        return views;
    }

    private Raster<Location> createRaster(List<String> lines) {
        Raster<Location> raster = new Raster<>(lines.get(0).length(), lines.size());

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == '#') {
                    raster.set(j, i, new Location(true));
                }
            }
        }

        return raster;
    }

}
