import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedView: 'book', // can be 'book', 'blog', 'course'
      showCourse: true
    };
  }

  renderContent = () => {
    // Conditional rendering using if-else
    if (this.state.selectedView === 'book') {
      return <BookDetails />;
    } else if (this.state.selectedView === 'blog') {
      return <BlogDetails />;
    } else {
      return <CourseDetails />;
    }
  };

  render() {
    // Using variable to store component
    let element;
    if (this.state.selectedView === 'blog') {
      element = <BlogDetails />;
    }

    return (
      <div style={{ textAlign: 'center' }}>
        <h1>Blogger App</h1>

        <div>
          <button onClick={() => this.setState({ selectedView: 'book' })}>Book Details</button>
          <button onClick={() => this.setState({ selectedView: 'blog' })}>Blog Details</button>
          <button onClick={() => this.setState({ selectedView: 'course' })}>Course Details</button>
        </div>

        <hr />

        {/* Conditional Rendering using method */}
        {this.renderContent()}

        <hr />

        {/* Conditional Rendering using element variable */}
        {element}

        <hr />

        {/* Conditional Rendering using logical && */}
        {this.state.showCourse && <CourseDetails />}
      </div>
    );
  }
}

export default App;
