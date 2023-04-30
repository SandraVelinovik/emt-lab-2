import './App.css';
import React, {useState, useEffect} from "react";
import {BrowserRouter as Router, Navigate, Route, Routes} from 'react-router-dom';
import Categories from "./components/Categories/categories";
import Header from "./components/Header/header";
import LibraryService from "./repo/libraryRepository";
import BookAdd from "./components/Books/BookAdd/bookAdd";
import BookEdit from "./components/Books/BookEdit/bookEdit";
import Books from "./components/Books/BookList/books";

function App() {
    const [categories, setCategories] = useState([]);
    const [books, setBooks] = useState([]);
    const [selectedBook, setSelectedBook] = useState({});

    useEffect(() => {
        loadBooks();
        loadCategories();
    }, []);

    const loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data) => {
                setBooks(data.data);
            });
    }

    const loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                setCategories(data.data);
            });
    }

    const deleteBook = (id) => {
        LibraryService.deleteBook(id)
            .then(() => {
                loadBooks();
            });
    }

    const addBook = (name, category, author, availableCopies) => {
        LibraryService.addBook(name, category, author, availableCopies)
            .then(() => {
                loadBooks();
            });
    }

    const getBook = (id) => {
        LibraryService.getBook(id)
            .then((data) => {
                setSelectedBook(data.data);
            })
    }

    const editBook = (id,name, category, author, availableCopies) => {
        LibraryService.editBook(id,name, category, author, availableCopies)
            .then(() => {
                loadBooks();
            });
    }

    return (
        <Router>
            <Header />
            <main>
                <div className="container">
                    <Routes>
                        <Route path="/categories"element={<Categories categories={categories}/>} />
                        <Route path="/books/add" element={<BookAdd categories={categories} onAddBook={addBook} />} />
                        <Route path="/books/edit/:id" element={<BookEdit book={selectedBook} categories={categories} onEditBook={editBook} />} />
                        <Route path="/books" element={<Books books={books} onDelete={deleteBook} onEdit={getBook} />} />
                        <Route path="/*" element={<Navigate to="/books" />} />
                    </Routes>
                </div>
            </main>
        </Router>
    );
}

export default App;