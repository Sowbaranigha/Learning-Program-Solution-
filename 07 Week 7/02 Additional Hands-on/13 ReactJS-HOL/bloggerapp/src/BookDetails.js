import React from 'react';

function BookDetails() {
  const books = [
    { id: 1, title: 'React Basics', author: 'John Doe' },
    { id: 2, title: 'Advanced React', author: 'Jane Smith' }
  ];

  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map(book => (
          <li key={book.id}>{book.title} - by {book.author}</li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
