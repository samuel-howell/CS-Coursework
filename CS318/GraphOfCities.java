package com.company;
//  Samuel Howell
//  2-3-21
//  CS318

//  Create a class GraphOfCities USING ADJECENCY MATRIX and use the HW1_testcode.java as a driver to test all the methods in your code. Take care of all possible edge cases.

import java.util.ArrayList;

public class CodePlayground
{

    public static void main(String[] args)
    {
        Graph graph1 = new GraphOfCities();

        String[] cities = {"Florence", "Columbia", "Charlotte", "Charleston", "Myrtle Beach"};
        int[][] distances =                                     //  this is the adjacency matrix
                {
                        {0, 92, 106, 136,  67},
                        {92, 0,  80, 120, 152},
                        {106, 80, 0, 209, 175},
                        {136, 120, 209, 0, 95},
                        { 67,152,  175, 95, 0}
                };
        Graph graph2 = new GraphOfCities(cities, distances);

        graph1.getSize();  //TODO: this is throwing an error bc its not initializing properly
        graph2.getSize();


        graph1.getNeighbors("Columbia");
        graph2.getNeighbors("Columbia");


        graph1.getDegree("Columbia");
        graph2.getDegree("Columbia");

        graph1.isEmpty();
        graph2.isEmpty();


        graph1.addVertex("Florence");
        graph1.addVertex("Columbia");
        graph1.addVertex("Charlotte");
        graph1.addEdge("Florence", "Columbia", 92);
        graph1.addEdge("Florence", "Charlotte", 106);
        graph1.addEdge("Columbia", "Charlotte", 80);


        graph1.printEdges();
        graph1.printVertices();

        System.out.println();

        graph2.printEdges();
        graph2.printVertices();

        graph1.deleteEdge("Columbia", "Charlotte");
        graph1.deleteEdge("Columbia", "Charlotte");


        graph2.deleteEdge("Columbia", "Charlotte");
        graph2.deleteEdge("Columbia", "Charlotte");


    }
}

//  abstract class of graph that I can create abstract methods in to implement in the GraphOfCities Class
abstract class Graph
{
    public abstract void addVertex(String city);
    public abstract void addEdge(String city1, String city2, int distancePoint);
    public abstract void printEdges();
    public abstract void printVertices();
    public abstract void isEmpty();
    public abstract void getNeighbors(String city);
    public abstract void deleteEdge(String city1, String city2);
    public abstract void getDegree(String city);
    public abstract void getSize();
}

//  GraphOfCities is a subclass of Graph that implements all of the abstract methods created in Graph
class GraphOfCities extends Graph
{
    private String[] cities;
    private int[][] distances;

    //  default constructor
    public GraphOfCities()
    {
        this.cities = new String[0];
        this.distances = new int[0][0];
    }

    //  constructor that takes in parameters
    public GraphOfCities(String[] cities, int[][] distances)
    {
        this.cities = cities;
        this.distances = distances;
    }


    @Override
    public void addVertex(String city)
    {
        String[] newCities = new String[cities.length + 1];

        //  copy old cities array
        for(int i = 0; i < cities.length; i++)
        {
            newCities[i] = cities[i];
        }

        // add new city to the end of the array
        newCities[newCities.length - 1] = city;

        setCities(newCities);

        // copy old distances to new distance array
        int[][] newDistances = new int[distances.length + 1][distances.length + 1];


        for (int i = 0; i < distances.length; i++)
        {
            for (int j = 0; j < distances.length; j++)
            {
                newDistances[i][j] = distances[i][j];
            }
        }

        //  populate the new row and new column with zeros (I now know it initializes to 0 by default)
        for(int i = 0; i < newDistances.length; i++)
        {
            newDistances[newDistances.length - 1][i] = 0;
            newDistances[i][newDistances.length - 1] = 0;
        }

        //  set the Distances adjacency array to the new distances
        setDistances(newDistances);
    }

    @Override
    public void addEdge(String city1, String city2, int distancePoint)
    {
        //  call helper function to quickly find indexes.
        int city1Index = findIndex(city1);
        int city2Index = findIndex(city2);

        //  assign the symmetrical spots in the adjacency matrix to this element called distancePoint.
        distances[city1Index][city2Index] = distancePoint;
        distances[city2Index][city1Index] = distancePoint;
    }

    @Override
    public void printEdges()
    {
        //  create an arraylist to hold all the pairs
        ArrayList<String> pairs = new ArrayList<>();

        //  populate pairs
        for(int i = 0; i < distances.length; i++)
        {
            for (int j = 0; j < distances.length; j++)
            {
                if(distances[i][j] != 0)            //  if there exists something at this index other than 0, thus signifying an edge, then...
                {
                    pairs.add(cities[i] + " - " + cities[j]);       //  add the row city and the column city with a hyphen between as a string to the arraylist.
                }
            }
        }

        //  print out pairs
        for(String pair : pairs)
        {
            System.out.println(pair);
        }
        System.out.println();       //  for formatting purposes

    }

    @Override
    public void printVertices()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cities.length; i++)
        {
            sb.append(cities[i] + ", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2));       //  use sb.length-2 to ignore the last comma.
        System.out.println();       //  for formatting purposes

    }

    @Override
    public void isEmpty()
    {
        if(cities.length != 0)  //  if there are no cities in the String[], then we know that the adjacency matrix must be empty.
        {
            System.out.println("false");
            System.out.println();       //  for formatting purposes

        }
        else
        {
            System.out.println("true");
            System.out.println();       //  for formatting purposes
        }

    }

    @Override
    public void getNeighbors(String city)
    {
        int cityIndex = findIndex(city);        //  use helper function to quickly find index.
        ArrayList<String> neighbors = new ArrayList<>();        //  create an arraylist to hold all of the neighbors

        //  populate neighbors arraylist
        if(cityIndex != -1)     //  makes sure we don't get an ArrayOutOfBounds exception
        {
            for(int i = 0; i < distances.length; i++)
            {
                if(distances[cityIndex][i] != 0)        //  check every index that exists on that city's row.
                {
                    neighbors.add(cities[i]);
                }
            }

            //  print out neighbors
            for(String neighbor : neighbors)
            {
                System.out.println(city + " neighbor : " + neighbor);
            }
            System.out.println();       //  for formatting purposes
        }
        else
        {
            System.out.println(city + " doesn't exist in String[] cities.");
            System.out.println();
        }


    }

    @Override
    public void deleteEdge(String city1, String city2)
    {
        //  call helper function to quickly find indexes.
        int city1Index = findIndex(city1);
        int city2Index = findIndex(city2);

        //  assign the symmetrical spots in the adjacency matrix to 0.
        distances[city1Index][city2Index] = 0;
        distances[city2Index][city1Index] = 0;
    }

    @Override
    public void getDegree(String city)
    {
        int counter = 0;
        int cityIndex = findIndex(city);

        if(cityIndex != -1)     //  makes sure that we don't get an ArrayIndexOutOfBounds exception
        {
            for(int i = 0; i < distances.length; i++)
            {
                if(distances[cityIndex][i] != 0) counter++;     //  check all of the elements on that city's row, and increment counter if they contain something other than 0.
            }

            System.out.println(city + " has " + counter + " degrees.");
            System.out.println();
        }
        else
        {
            System.out.println(city + " doesn't have any degrees.");
            System.out.println();
        }

    }

    @Override
    public void getSize()
    {
        int counter = 0;


            for(int i = 0; i < distances.length; i++)
            {
                for(int j = i; j < distances.length; j++)   //  by setting j = i, we make sure that we take the symmetrical aspect of the Adjacency matrix into account, and don't double count.
                {
                    if(distances[i][j] != 0) counter++;
                }
            }

            System.out.println("The graph has " + cities.length + " vertices and " + counter + " edges");
            System.out.println();
    }

    //  helper function used to quickly find index
    public int findIndex(String city)
    {
        int count = 0;
           for(int i = 0 ; i < cities.length; i++)
           {
               if(cities[i].equals(city)) return count;
               else count++;
           }

           return  -1;
    }

    //  boilerplate setters.
    public void setCities(String[] cities)
    {
        this.cities = cities;
    }

    public void setDistances(int[][] distances)
    {
        this.distances = distances;
    }
}



