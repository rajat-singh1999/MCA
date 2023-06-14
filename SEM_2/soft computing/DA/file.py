# code cell 1
import os
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, MaxPooling2D, Flatten, Dense, Dropout
from tensorflow.keras.applications import ResNet50, VGG16

# code cell 2
data_directory = r'archive\train'

train_datagen = ImageDataGenerator(rescale=1./255, validation_split=0.3)

train_generator = train_datagen.flow_from_directory(
    data_directory,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical',
    subset='training'
)

validation_generator = train_datagen.flow_from_directory(
    data_directory,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical',
    subset='validation'
)

# code cell 3
alexnet_model = Sequential()
alexnet_model.add(Conv2D(96, kernel_size=(11, 11), strides=(4, 4), activation='relu', input_shape=(224, 224, 3)))
alexnet_model.add(MaxPooling2D(pool_size=(3, 3), strides=(2, 2)))
alexnet_model.add(Conv2D(256, kernel_size=(5, 5), activation='relu'))
alexnet_model.add(MaxPooling2D(pool_size=(3, 3), strides=(2, 2)))
alexnet_model.add(Conv2D(384, kernel_size=(3, 3), activation='relu'))
alexnet_model.add(Conv2D(384, kernel_size=(3, 3), activation='relu'))
alexnet_model.add(Conv2D(256, kernel_size=(3, 3), activation='relu'))
alexnet_model.add(MaxPooling2D(pool_size=(3, 3), strides=(2, 2)))
alexnet_model.add(Flatten())
alexnet_model.add(Dense(4096, activation='relu'))
alexnet_model.add(Dropout(0.5))
alexnet_model.add(Dense(4096, activation='relu'))
alexnet_model.add(Dropout(0.5))
alexnet_model.add(Dense(5, activation='softmax'))

alexnet_model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

alexnet_history = alexnet_model.fit(train_generator, validation_data=validation_generator, epochs=3)

# code cell 4
# Save the trained model
alexnet_model.save('alexnet_model.h5')

# code cell 5
# Load the saved model
saved_model = tf.keras.models.load_model('alexnet_model.h5')

# Test the model on new data
test_directory =  r'archive\test'

test_datagen = ImageDataGenerator(rescale=1./255)

test_generator = test_datagen.flow_from_directory(
    test_directory,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical',
    shuffle=False
)

# Evaluate the saved model
scores = saved_model.evaluate(test_generator)
print("Test Loss:", scores[0])
print("Test Accuracy:", scores[1])

# code cell 6
# Make predictions using the saved model
predictions = saved_model.predict(test_generator)
predictions

# code cell 7
resnet_model = Sequential()
resnet_model.add(ResNet50(include_top=False, pooling='avg', weights='imagenet'))
resnet_model.add(Dense(5, activation='softmax'))

resnet_model.layers[0].trainable = False

resnet_model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

resnet_history = resnet_model.fit(train_generator, validation_data=validation_generator, epochs=3)

# code cell 8
resnet_model.save('resnet_model.h5')

# code cell 9
# Load the saved model
saved_model = tf.keras.models.load_model('resnet_model.h5')

# Test the model on new data
test_directory =  r'archive\test'

test_datagen = ImageDataGenerator(rescale=1./255)

test_generator = test_datagen.flow_from_directory(
    test_directory,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical',
    shuffle=False
)

# Evaluate the saved model
scores = saved_model.evaluate(test_generator)
print("Test Loss:", scores[0])
print("Test Accuracy:", scores[1])

# code cell 10
vgg_model = Sequential()
vgg_model.add(VGG16(include_top=False, pooling='avg', weights='imagenet'))
vgg_model.add(Dense(5, activation='softmax'))

vgg_model.layers[0].trainable = False

vgg_model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])

vgg_history = vgg_model.fit(train_generator, validation_data=validation_generator, epochs=3)

# code cell 11
vgg_model.save('vgg_model.h5')

# code cell 12
# Load the saved model
saved_model = tf.keras.models.load_model('vgg_model.h5')

# Test the model on new data
test_directory =  r'archive\test'

test_datagen = ImageDataGenerator(rescale=1./255)

test_generator = test_datagen.flow_from_directory(
    test_directory,
    target_size=(224, 224),
    batch_size=32,
    class_mode='categorical',
    shuffle=False
)

# Evaluate the saved model
scores = saved_model.evaluate(test_generator)
print("Test Loss:", scores[0])
print("Test Accuracy:", scores[1])
