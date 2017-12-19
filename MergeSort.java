 
import java.util.*;

public class MergeSort
{
	public static void main(String[] args)
	{
		Integer[] a = {2, 6, 3, 5, 1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


 	private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int izquierda, int derecha)
	{
		if( izquierda < derecha )
		{
			int center = (izquierda + derecha) / 2;
			mergeSort(a, tmp, izquierda, center);
			mergeSort(a, tmp, center + 1, derecha);
 			merge(a, tmp, izquierda, center + 1, derecha);
		}
	}


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int izquierda, int derecha, int derechaEnd )
    {
        int izquierdaEnd = derecha - 1;
        int k = izquierda;
        int num = derechaEnd - izquierda + 1;

        while(izquierda <= izquierdaEnd && derecha <= derechaEnd)
            if(a[izquierda].compareTo(a[derecha]) <= 0)
                tmp[k++] = a[izquierda++];
            else
                tmp[k++] = a[derecha++];

        while(izquierda <= izquierdaEnd)    // Copia el resto de la primera mitad
            tmp[k++] = a[izquierda++];

        while(derecha <= derechaEnd)  // copia el resto de la mitad derecha
            tmp[k++] = a[derecha++];

        // reemplaza el valor tmp
        for(int i = 0; i < num; i++, derechaEnd--)
            a[derechaEnd] = tmp[derechaEnd];
    }
 }
