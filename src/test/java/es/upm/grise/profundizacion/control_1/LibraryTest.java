package es.upm.grise.profundizacion.control_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {


	@Test
	public void AddLibroTest() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book libro1 = new Book("libro1");
		Library library = new Library();
		library.addBook(libro1);

		// Compruebo que me devuelve el libro y no una excepción
		assertNotNull(library.getBook("libro1"));
		assertEquals(libro1, library.getBook("libro1"));
		// compruebo Excepcion de libro repetido
 		assertThrows(DuplicatedBookException.class, () -> library.addBook(libro1));


	}

	@Test
	public void DeleteLibroTest() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book libro1 = new Book("libro1");
		Book libro2 = new Book("libro2");
		Library library = new Library();
		library.addBook(libro1);
		library.addBook(libro2);

		// Compruebo que existe el libro
		assertNotNull(library.getBook("libro1"));
		assertEquals(libro1, library.getBook("libro1"));

		// Borro el libro 1 y compruebo que no existe con excepcion de libro no existente
		library.removeBook(libro1);
		assertThrows(NonExistingBookException.class, () -> library.getBook("libro1"));
		// Borro tambien el libro 2 y compruebo que se ha borrado correctamente con la excepcion de que es lista vacia
		library.removeBook(libro2);
		assertThrows(EmptyLibraryException.class, () -> library.getBook("libro1"));




	}

	@Test
	public void GetLibroTest() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Book libro1 = new Book("libro1");
		Library library = new Library();
		library.addBook(libro1);
		// Compruebo que me devuelve el libro que quiero
		assertEquals(libro1, library.getBook("libro1"));
		// Compruebo que no existe el libro 2
		assertThrows(NonExistingBookException.class, () -> library.getBook("libro2"));
		library.removeBook(libro1);
		// Compruebo lista vacia
		assertThrows(EmptyLibraryException.class, () -> library.getBook("libro1"));
	}

	// Añadir nombre texto significativo al commit...


}
